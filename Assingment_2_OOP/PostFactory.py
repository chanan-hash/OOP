import args

from post.ImagePost import ImagePost
from post.TesxtPost import TextPost
from post.SalePost import SalePost
from post.Post import Post


class PostFactory:
    @staticmethod
    def create_post(post_type: str, creator, *args) -> Post:
        if post_type == "Text":
            post = TextPost(creator, *args)
        elif post_type == "Sale":
            post = SalePost(creator, *args)
        elif post_type == "Image":
            post = ImagePost(creator, *args)
        else:
            raise ValueError(f"Invalid post type for type: {post_type}")

        print(post)
        return post
