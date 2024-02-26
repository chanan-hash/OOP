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
        self._followers = Set[
            "User"] = set()  # creating a set that holds the followers. set saving us checking if someone tried to do follow twice
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

        user.followers.add(self)

        print(f'{self.username} started following {user.username}')

    def unfollow(self, user: "User") -> None:
        """
        Unfollow a given user, and updating the user followers set
        If he is not following him, raise exception
        :param user:
        :return:
        """
        User.check_if_user_login(self)

        if self in user._followers:
            user.remove(self)
            print(f"{self.username} unfollowed {user.username}")

        # Trying to unfollow a user that is not following him
        else:
            raise IllegalOperationError("User is not following the given user")

    def notify(self, message: str, log: bool, extra_message: str = "") -> None:
        pass

    def get_followers(self) -> Set["User"]:
        """
        Gets the user followers
        :return: A set of the followers
        """
        return self._followers  # TODO handle this

    @staticmethod
    def check_if_user_login(user) -> None:
        pass
