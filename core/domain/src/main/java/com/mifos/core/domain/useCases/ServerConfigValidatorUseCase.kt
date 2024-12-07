package com.mifos.core.domain.useCases

import javax.inject.Inject

data class ServerConfigValidatorUseCase @Inject constructor(
    val validateServerProtocol: ValidateServerProtocolUseCase,
    val validateEndPoint: ValidateServerEndPointUseCase,
    val validateApiPath: ValidateServerApiPathUseCase,
    val validatePort: ValidateServerPortUseCase,
    val validateTenant: ValidateServerTenantUseCase,
)
