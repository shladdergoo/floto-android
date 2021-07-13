package com.datagility.floto

class ClientConfig {

    private var _scheme: String = "https"
    private var _authority: String = ""

    var scheme: String
        get() {
            return _scheme
        }
        set(value) { _scheme = value }

    var authority: String
        get() {
            return _authority
        }
        set(value) { _authority = value }
}
