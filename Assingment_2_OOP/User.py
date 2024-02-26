from __future__ import annotations
from typing import TYPE_CHECKING, Set, List

if TYPE_CHECKING:
    from post.Post import Post

# type Checking helpers

from CostomException import NotLoginError, IllegalOperationError
from PostFactory import PostFactory


class User:
    _post_factory = PostFactory()

    def __init__(self, username: str, password: str):
        if len(password) < 4 or len(password) > 8:
            raise ValueError("Password must be 4 to 8 characters long")

        self.username = username
        self.password = password
        self._followers: Set["User"] = set()  # creating a set that holds the followers. set saving us checking if someone tried to do follow twice
        self._post_num = 0  # How many posts the user have posted
        self._notifications: List[str] = []  # A list that hold all user notifications

    def follow(self, user: "User") -> None:
        """
        Follow a given user.
        And updating the user's followers set
        :param user: User to follow
        :return: None
        """
        User.check_if_user_login(self)

        if user == self:
            raise ValueError("Cannot follow yourself")

        user._followers.add(self)

        print(f'{self.username} started following {user.username}')

    def unfollow(self, user: "User") -> None:
        """
        Unfollow a given user, and updating the user followers set
        If he is not following him, raise exception
        :param user:
        """
        User.check_if_user_login(self)

        if self in user._followers:
            user.remove(self)
            print(f"{self.username} unfollowed {user.username}")

        # Trying to unfollow a user that is not following him
        else:
            raise IllegalOperationError("User is not following the given user")

    def publish_post(self, post_type: str, *args):
        """
        Publish a post according to it's type
        It we'll be created according to the post-factory

        :param post_type: Type of the post to br published ["Text", "Sale", "Image"]
        :param args: the arguments to pass to the post. beacue each king of post getting something else, we're using the args keyword
        """

        User.check_if_user_login(self)
        new_post = User._post_factory.create_post(post_type, self, *args)
        self._post_num += 1
        return new_post

    def notify(self, message: str, log: bool, extra_message: str = "") -> None:
        """
        Notify a user with a given message.
        If the log == True, it will print the edited message.
        :param message: message to notify
        :param log: print it or not
        :param extra_message: extra message to print
        :return: None
        """
        self._notifications.append(message)
        if log:  # Trying to add to existing notification
            print(f"notification to {self.username}: {message}{extra_message}")

    def print_notifications(self):
        print(f"{self.username}'s notifications:")
        for notification in self._notifications:
            print(notification)

    def compare_password(self, password: str) -> bool:
        """
        Comparing a given password to user's passowrd
        :param password: password to compare
        :return: True is equal, and False if not
        """
        return self.password == password

    def get_followers(self) -> Set["User"]:
        """
        Gets the user followers
        :return: A set of the followers
        """
        return self._followers

    # This is like a toString function
    def __str__(self) -> str:
        return f"User name: {self.username}, Number of posts: {self._post_num}, Number of followers {len(self._followers)}"

    def __repr__(self) -> str:
        return self.__str__()

    # equal function, comparing between to users by their username
    def __eq__(self, other):
        if isinstance(other, User):
            return self.username == other.username
        return False

    def __hash__(self):
        return hash(self.username)

    @staticmethod
    def check_if_user_login(user) -> None:
        from SocialNetwork import SocialNetwork
        # Only logged-on user will be able to do the function above
        if not SocialNetwork.get_instance().is_user_logged(user):
            raise NotLoginError("User is not logged in")
