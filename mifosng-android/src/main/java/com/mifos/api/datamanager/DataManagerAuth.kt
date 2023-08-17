package com.mifos.api.datamanager

import org.apache.fineract.client.models.PostAuthenticationRequest
import org.apache.fineract.client.models.PostAuthenticationResponse
import org.mifos.core.apimanager.BaseApiManager
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Rajan Maurya on 19/02/17.
 */
@Singleton
class DataManagerAuth @Inject constructor(private val baseApiManager: BaseApiManager) {
    /**
     * @param username Username
     * @param password Password
     * @return Basic OAuth
     */
    fun login(username: String, password: String): Observable<PostAuthenticationResponse> {
        val body = PostAuthenticationRequest()
        body.username = username
        body.password = password
        return baseApiManager.getAuthApi().authenticate(body, true)
    }
}