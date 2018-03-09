package config

import co.enoobong.rave.flutterwave.data.Environment
import co.enoobong.rave.flutterwave.service.RavePay
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

/**
 * @author Ibanga Enoobong I
 * @since 3/4/18.
 */

class RaveBuilderSpec : Spek({

    given("a rave pay builder") {
        val secretKey = "FLWSECK-bb971402072265fb156e90a3578fe5e6-X"
        val publicKey = "FLWPUBK-1c0065cff0c9141555198872abc3ba08-X"
        val ravePayBuilder = RavePay.Builder()

        on("build called without secret key") {
            it("should throw illegal argument exception") {
                assertFailsWith<IllegalArgumentException> {
                    ravePayBuilder.build()
                }
            }
        }

        on("build called without public key") {
            ravePayBuilder.setSecretKey(secretKey)
            it("should throw illegal argument exception") {
                assertFailsWith<IllegalArgumentException> {
                    ravePayBuilder.build()
                }
            }
        }

        on("Properly filled arguments") {
            val ravePay = ravePayBuilder
                .setSecretKey(secretKey)
                .setPublicKey(publicKey)
                .setEnvironment(Environment.STAGING)
                .build()
            it("construct RavePay instance") {
                assertNotNull(ravePay)
            }
        }
    }

})