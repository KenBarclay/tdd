package com.adt.kotlin.tdd.wrapper

/**
 * ...
 *
 * @author	                    Ken Barclay
 * @since                       January 2020
 */

import com.adt.kotlin.data.immutable.option.Option
import com.adt.kotlin.data.immutable.option.OptionF


object PostcodeWrapperF {

    data class Postcode private constructor(val postcode: String) {

        companion object {

            /**
             * Factory constructor for UK posrcodes.
             */
            fun makePostcode(text: String): Option<Postcode> =
                if (regex.containsMatchIn(text))
                    OptionF.some(Postcode(text))
                else
                    OptionF.none()

            private val regex: Regex = Regex("^([A-Z][A-HJ-Y]?[0-9][A-Z0-9]? ?[0-9][A-Z]{2}|GIR ?0A{2})\$")

        }

    }

}   // PostcodeWrapperF
