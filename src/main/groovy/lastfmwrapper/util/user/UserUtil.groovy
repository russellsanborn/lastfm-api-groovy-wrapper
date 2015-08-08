package lastfmwrapper.util.user

import lastfmwrapper.domain.user.UserGetInfo
import lastfmwrapper.service.user.UserService
import retrofit.RestAdapter
import retrofit.RetrofitError

class UserUtil {
    UserService userService

    UserUtil() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint('http://ws.audioscrobbler.com/2.0')
                .build()
        userService = restAdapter.create(UserService)
    }

    UserGetInfo getInfo(String user, String token) {
        UserGetInfo userGetInfo
        try {
            userGetInfo = userService.getInfo(user, token)
        } catch (RetrofitError error) {
            userGetInfo = null
        }
        return userGetInfo
    }
}
