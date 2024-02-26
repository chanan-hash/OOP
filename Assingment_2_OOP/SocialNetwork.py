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

        user = User(username, password) # Creating a User object
        self._users[username] = user # Adding it to the dictionary
        self._logged_in.add(user) # logged in when register
        return user

    def log_out(self, username: str) -> None:
        if username in self._user: # non-registered user trying to log-out
            raise UserDoesNotExistError("Username does not exists")

        if self._users[username] not in self._logged_in:
            raise NotLoginError("Can't log out a user that is not logged in")