package lastfmwrapper.util.user

import lastfmwrapper.domain.user.User
import lastfmwrapper.domain.user.UserGetInfo
import lastfmwrapper.service.user.UserService
import retrofit.RetrofitError
import spock.lang.Specification

class UserUtilSpec extends Specification {
    UserUtil userUtil

    def setup() {
        userUtil = new UserUtil()
        userUtil.userService = Mock(UserService)
    }

    void 'user.getInfo is called'() {
        setup: 'a user and an api token'
        String user = 'raccoon'
        String token = 'squirrel'
        UserGetInfo mockUserGetInfo = new UserGetInfo(user: new User(name: user))

        when: 'calling user.getInfo'
        UserGetInfo output = userUtil.getInfo(user, token)

        then: 'last.fm user.getInfo is called with the user and token'
        1 * userUtil.userService.getInfo(user, token) >> mockUserGetInfo
        0 * _
        output == mockUserGetInfo
    }

    void 'if user.getInfo throws an exception, a null UserGetInfo is returned'() {
        setup: 'a user and an api token'
        String user = 'raccoon'
        String token = 'squirrel'

        when: 'calling user.getInfo'
        UserGetInfo output = userUtil.getInfo(user, token)

        then: 'thrown an exception'
        1 * userUtil.userService.getInfo(user, token) >> {
            throw new RetrofitError('error', null, null , null, null, null, null)
        }
        !output
    }
}
