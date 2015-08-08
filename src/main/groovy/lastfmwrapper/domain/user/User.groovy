package lastfmwrapper.domain.user

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import lastfmwrapper.domain.image.Image

@ToString
@EqualsAndHashCode
class User {
    String age
    String bootstrap
    String country
    String gender
    String id
    String name
    String playcount
    String playlists
    String realname
    String subscriber
    String type
    String url

    List<Image> image
    UserRegistered registered
}
