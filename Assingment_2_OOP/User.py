from __future__ import annotations
from typing import TYPE_CHECKING, Set, List

if TYPE_CHECKING:
   from post.Post import Post

# type Checking helpers

from CostomException import NotLoginError, IllegalOperationError
from PostFactory import PostFactory #TODO need to be implemented

class User:
    _post_factory = PostFactory()

    def __init__(self, username: str, password: str):
        if len(password) < 4 or len(password) > 8:
            raise ValueError("Password must be 4 to 8 characters long")

        self.username = username
        self.password = password

    def notify(self, message: str, log: bool, extra_message: str= "")-> None:
        pass

    def get_followers(self) -> Set["User"]:
        """
        Gets the user followers
        :return: A set of the followers
        """
        return self._followers # TODO handle this
