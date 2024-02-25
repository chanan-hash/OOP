from __future__ import annotations

from typing import TYPE_CHECKING, Set

if TYPE_CHECKING:
    from User import User

from abc import ABC, abstractmethod

from CostomException import NotLoginError
from Notificator import Notificator


class Post(ABC):
    _notificator = Notificator()

    def __init__(self, creator: User):
        self._creator = creator
        self._likes: Set = set()  # Creating a set that will hold the likes on the post. each user can do one like for a post

        Post._notificator.notify_all_followers(creator,f"{creator.username} has a new post") # Notifying on a post

    def like (self, user: User)-> None:
        Post.check_if_user_logged(user) # checking if the user is logged and can comment

        if user not in self._likes: # Adding a new user on like list of the post
            self._likes.add(user)
            # Notify the post's user that someone liked his post
            Post._notificator.notify_user(self._creator,user, f'{user.username} liked your post', True)

    def comment(self, user: User, comment: str):
        Post.check_if_user_logged(user) # checking if the user is logged and can comment
        Post._notificator.notify_user(self._creator, user, f'{user.username} commented your post', True, f"{comment}")

    def get_creator(self):
        return self._creator

    @staticmethod
    def check_if_user_logged(user: User):
        #from SocialNetwork import SocialNetwork
        if not SocialNetwork.get_instance().is_user_logged_in(user):
            raise NotLoginError("User is not logged in")

    def __str__(self):
        return self.__repr__()