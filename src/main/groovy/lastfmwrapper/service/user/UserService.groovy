package lastfmwrapper.service.user

import lastfmwrapper.domain.user.UserGetInfo
import retrofit.http.GET
import retrofit.http.Query

interface UserService {
    @GET('/?method=user.getinfo&format=json')
    UserGetInfo getInfo(@Query('user') String user, @Query('api_key') String apiKey)
}
