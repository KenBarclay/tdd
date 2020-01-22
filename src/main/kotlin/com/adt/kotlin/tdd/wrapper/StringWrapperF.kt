package com.adt.kotlin.tdd.wrapper

/**
 * ...
 *
 * @author	                    Ken Barclay
 * @since                       January 2020
 */

import com.adt.kotlin.data.immutable.option.Option
import com.adt.kotlin.data.immutable.option.OptionF



object StringWrapperF {

    data class String100 private constructor(val text: String) {

        companion object {

            /**
             * Factory constructor for strings of length 100
             */
            fun make(text: String): Option<String100> {
                return create(singleLineTrimmed, lengthValidator(100), text){str: String -> String100(str)}
            }   // make

        }

    }   // String100

    data class String50 private constructor(val text: String) {

        companion object {

            /**
             * Factory constructor for strings of length 50.
             */
            fun make(text: String): Option<String50> {
                return create(singleLineTrimmed, lengthValidator(50), text){str: String -> String50(str)}
            }   // make

        }

    }   // String50

    data class String40 private constructor(val text: String) {

        companion object {

            /**
             * Factory constructor for strings of length 40.
             */
            fun make(text: String): Option<String40> {
                return create(singleLineTrimmed, lengthValidator(40), text){str: String -> String40(str)}
            }   // make

        }

    }   // String40

    data class String30 private constructor(val text: String) {

        companion object {

            /**
             * Factory constructor for strings of length 30.
             */
            fun make(text: String): Option<String30> {
                return create(singleLineTrimmed, lengthValidator(30), text){str: String -> String30(str)}
            }   // make

        }

    }   // String30

    data class String20 private constructor(val text: String) {

        companion object {

            /**
             * Factory constructor for strings of length 20.
             */
            fun make(text: String): Option<String20> {
                return create(singleLineTrimmed, lengthValidator(20), text){str: String -> String20(str)}
            }   // make

        }

    }   // String20

    data class String10 private constructor(val text: String) {

        companion object {

            /**
             * Factory constructor for strings of length 10.
             */
            fun make(text: String): Option<String10> {
                return create(singleLineTrimmed, lengthValidator(10), text){str: String -> String10(str)}
            }   // make

        }

    }   // String10

    data class String5 private constructor(val text: String) {

        companion object {

            /**
             * Factory constructor for strings of length 5.
             */
            fun make(text: String): Option<String5> {
                return create(singleLineTrimmed, lengthValidator(5), text){str: String -> String5(str)}
            }   // make

        }

    }   // String5

    /**
     * Create a wrapped value option. First canonical the value first, then
     *   if the validation succeeds return Some of the of the given constructor;
     *   otherwise return None.
     *
     * @param canonicalise      function to canonicalise the input string
     * @param validate          validation function on the canonicalised string
     * @param string            the input text
     * @param ctor              the constructor function
     * @return                  option for the constructed value
     */
    private fun <T> create(canonicalise: (String) -> String, validate: (String) -> Boolean, string: String, ctor: (String) -> T): Option<T> {
        return if (string == "")
            OptionF.none()
        else {
            val str: String = canonicalise(string)
            if (validate(str))
                OptionF.some(ctor(str))
            else
                OptionF.none()
        }
    }   // create

    /**
     * Convert all whitespace to a single space.
     */
    private val singleLineTrimmed: (String) -> String =
        {text: String ->
            val regex: Regex = Regex("\\s")
            regex.replace(text, " ")
        }

    /**
     * Validation function based on the string length.
     */
    private val lengthValidator: (Int) -> (String) -> Boolean =
        {length: Int ->
            {text: String ->
                text.length <= length
            }
        }

}   // StringWrapperF
