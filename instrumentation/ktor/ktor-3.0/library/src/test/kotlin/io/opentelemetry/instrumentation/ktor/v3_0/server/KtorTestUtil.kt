/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.ktor.v3_0.server

import io.ktor.server.application.*
import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.instrumentation.testing.junit.http.AbstractHttpServerTest

class KtorTestUtil {
  companion object {
    fun installOpenTelemetry(application: Application, openTelemetry: OpenTelemetry) {
      application.install(KtorServerTracing.Feature) {
        setOpenTelemetry(openTelemetry)
        capturedRequestHeaders(AbstractHttpServerTest.TEST_REQUEST_HEADER)
        capturedResponseHeaders(AbstractHttpServerTest.TEST_RESPONSE_HEADER)
      }
    }
  }
}
