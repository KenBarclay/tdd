package com.adt.kotlin.tdd.wrapper

/**
 * ...
 *
 * @author	                    Ken Barclay
 * @since                       January 2020
 */

import com.adt.kotlin.data.immutable.option.Option
import com.adt.kotlin.data.immutable.option.OptionF.none
import com.adt.kotlin.data.immutable.option.OptionF.some



object IntWrapperF {

    data class PositiveInt private constructor(val value: Int) {

        companion object {

            fun makePositiveInt(value: Int): Option<PositiveInt> =
                if (value < 0)
                    none()
                else
                    some(PositiveInt(value))
        }

    }   // PositiveInt

    data class PositiveInt0 private constructor(val value: Int) {

        companion object {

            fun makePositiveInt0(value: Int): Option<PositiveInt0> =
                if (value < 0)
                    none()
                else
                    some(PositiveInt0(value))
        }

    }   // PositiveInt0

    data class PositiveInt1 private constructor(val value: Int) {

        companion object {

            fun makePositiveInt1(value: Int): Option<PositiveInt1> =
                if (value <= 0)
                    none()
                else
                    some(PositiveInt1(value))
        }

    }   // PositiveInt1

    data class NegativeInt private constructor(val value: Int) {

        companion object {

            fun makeNegativeInt(value: Int): Option<NegativeInt> =
                if (value >= 0)
                    none()
                else
                    some(NegativeInt(value))
        }

    }   // NegativeInt

}   // IntWrapperF
