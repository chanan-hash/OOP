from typing import Dict, Set

from CostomException import UsernameAlreadyExistsError, UserDoesNotExistError, NotLoginError, InvalidCredentialsError
from User import User


class SocialNetwork:
    """
    This class representing the social network.
    It implements the Singleton design pattern by allowing to create only one instance
    """
    __instance = None  # for implementing Singleton design pattern
    __is_initialized = False

    @staticmethod
    def get_instance():
        if SocialNetwork.__instance is None:  # or == None
            raise ValueError("The social network wat not created yet")
        return SocialNetwork.__instance

    # Creating a new instance of the class
    def __new__(cls, name: str):
        if cls.__instance is None:
            cls.__instance = super().__new__(cls)
        return cls.__instance

    # name --> network name
    def __init__(self, name: str):
        if self.__is_initialized:
            return  # An instance of the class has been already initialized
        self._name = name
        self._users: Dict[str, User] = dict()  # Will access the user's info by their name
        self._logged_in: Set[User] = set()  # Set of the logged users

        self.__is_initialized = True  # An instance of the class has been created now

        print(f"The social network {name} was created!")

    def sing_up(self, username: str, password: str):
        if username in self._user:
            raise UsernameAlreadyExistsError("Username already exists")

        user = User(username, password)  # Creating a User object
        self._users[username] = user  # Adding it to the dictionary
        self._logged_in.add(user)  # logged in when register
        return user

    def log_out(self, username: str) -> None:
        if username in self._user:  # non-registered user trying to log-out
            raise UserDoesNotExistError("Username does not exists")

        if self._users[username] not in self._logged_in:
            raise NotLoginError("Can't log out a user that is not logged in")

        self._logged_in.remove(self._users[username])
        print(f"{username} disconnected")

    def log_in(self, username: str, password: str) -> None:
        # Checking if the user has been already registered and the correctness of username and password input
        if username not in self._users or self._users[username].compare_password(password) is False:
            raise InvalidCredentialsError("Invalid credentials")

        user = self._users[username]

        self._logged_in.add(user)  # The logged in Set
        print(f'{username} connected')

    def is_user_logged(self, user: User) -> bool:
        return user in self._logged_in

    # The toString of the class --> means class info in String format
    def __str__(self):
        users = "\n".join(
            [str(u) for u in self._users.values()])  # lambda for iterating the all users in the dictionary
        return f"{self._name} social network:\n{users}"

    def __repr__(self):
        return self.__str__()
