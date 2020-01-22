package com.adt.kotlin.tdd.wrapper

/**
 * ...
 *
 * @author	                    Ken Barclay
 * @since                       January 2020
 */

import com.adt.kotlin.data.immutable.option.Option
import com.adt.kotlin.data.immutable.option.OptionF



object EmailWrapperF {

    data class EMail private constructor(val email: String) {

        companion object {

            /**
             * Factory constructor for emails.
             */
            fun makePostcode(text: String): Option<EMail> =
                if (regex.containsMatchIn(text))
                    OptionF.some(EMail(text))
                else
                    OptionF.none()

            private val regex: Regex = Regex("/^[a-zA-Z0-9.!#\$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\\$/")

        }

    }

}   // EmailWrapperF
