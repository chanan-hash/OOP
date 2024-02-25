from __future__ import annotations
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from User import User

from post.Post import Post


class TextPost(Post):
    def __init__(self, creator: User, content: str):
        super().__init__(creator)  # The creator of the post, the user
        self._content = content

    def __repr__(self):
        return f"{super.get_creator().username} published a post:\n'{self.content}'\n"
