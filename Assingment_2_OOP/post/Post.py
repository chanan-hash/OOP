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

    def like (self, user: User):
