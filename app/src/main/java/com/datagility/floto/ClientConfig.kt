package com.datagility.floto

class ClientConfig {

    private val _scheme: String = "https"
    private var _authority: String = ""

    val scheme: String
        get() {
            return _scheme
        }

    var authority: String
        get() {
            return _authority
        }
        set(value) { _authority = value }
}
