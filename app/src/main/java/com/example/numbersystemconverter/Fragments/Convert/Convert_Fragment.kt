package com.example.numbersystemconverter.Fragments.Convert

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.numbersystemconverter.R
import kotlinx.android.synthetic.main.fragment_convert_.*

class Convert_Fragment : Fragment() {

    var conv = Conversion()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_convert_, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val conv_items = listOf("Binary", "Decimal", "Octal", "HexaDecimal")

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_conv, conv_items)
        btn_share.visibility= View.GONE
        autoComplete_from.setAdapter(adapter)
        autoComplete_to.setAdapter(adapter)

        btn_share.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, tv_result.text.toString())
                type = "text/plain"

            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }

        btn_convert.setOnClickListener {
            if (num_field.text.isNullOrEmpty()){
                btn_share.visibility= View.GONE
            }else{
                btn_share.visibility = View.VISIBLE
            }
            when (autoComplete_from.text.toString()) {
                "Binary" ->
                    if (num_field.text!!.contains("0") || num_field.text!!.contains("1")) {
                        from_binary_check_to()
                    } else {
                        num_field.error = "Digits must be 0 and 1"
                    }
                "Decimal" -> {
                    from_decimal_check_to()
                }
                "Octal" -> {
                    if (num_field.text!!.contains("8") || num_field.text!!.contains("9")) {
                        num_field.error = "Digits 8 and 9 are invalid"
                    } else {
                        from_octal_check_to()
                    }

                }
                "HexaDecimal" -> {
                    from_hex_check_to()
                }

            }
        }

        super.onViewCreated(view, savedInstanceState)
    }

    fun from_decimal_check_to() {
        when (autoComplete_to.text.toString()) {
            "Binary" -> {
                tv_result.text = conv.decimal_to_binary(num_field.text.toString().toLong())

            }
            "Decimal" -> {
                tv_result.text = num_field.text
            }
            "Octal" -> {
                tv_result.text = conv.decimal_to_octal(num_field.text.toString().toLong())
            }
            "HexaDecimal" -> {
                tv_result.text = conv.decimal_to_hexadecimal(num_field.text.toString().toLong())
            }
        }
    }

    fun from_binary_check_to() {
        when (autoComplete_to.text.toString()) {
            "Binary" -> {
                tv_result.text = num_field.text
            }
            "Decimal" -> {
                tv_result.text = conv.binary_to_decimal(num_field.text.toString().toLong())
            }
            "Octal" -> {
                tv_result.text = conv.binary_to_octal(num_field.text.toString().toLong())
            }
            "HexaDecimal" -> {
                tv_result.text = conv.binary_to_hexadecimal(num_field.text.toString().toLong())
            }

        }
    }

    fun from_octal_check_to() {
        when (autoComplete_to.text.toString()) {
            "Binary" -> {
                tv_result.text = conv.octal_to_binary(num_field.text.toString().toLong())
            }
            "Decimal" -> {
                tv_result.text = conv.octal_to_decimal(num_field.text.toString().toLong())
            }
            "Octal" -> {
                tv_result.text = num_field.text
            }
            "HexaDecimal" -> {
                tv_result.text = conv.octal_to_hexcode(num_field.text.toString().toLong())
            }

        }
    }

    fun from_hex_check_to() {
        when (autoComplete_to.text.toString()) {
            "Binary" -> {
                tv_result.text = conv.hex_to_binary(num_field.text.toString())
            }
            "Decimal" -> {
                tv_result.text = conv.hex_to_decimal(num_field.text.toString())
            }
            "Octal" -> {
                tv_result.text = conv.hex_to_octal(num_field.text.toString())
            }
            "HexaDecimal" -> {
                tv_result.text = num_field.text
            }
        }
    }
}










