package lastfmwrapper.domain.user

import com.google.gson.annotations.SerializedName


class UserRegistered {
    @SerializedName('#text')
    String text

    String unixtime
}
