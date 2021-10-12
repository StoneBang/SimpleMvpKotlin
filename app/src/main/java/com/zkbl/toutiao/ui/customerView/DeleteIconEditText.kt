package com.zkbl.toutiao.ui.customerView

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.zkbl.toutiao.R

/**
 * Create by StoneBang at 2021/9/13
 */
class DeleteIconEditText @JvmOverloads constructor(context: Context, attrs:AttributeSet?=null, defStyleAttr:Int= R.attr.editTextStyle):AppCompatEditText(context,attrs,defStyleAttr),TextWatcher{
    private var draw:Drawable?=null
    private var drawShow:Drawable?=null

    init{
        draw = ContextCompat.getDrawable(context,R.drawable.icon_delete)
        val minWidth:Int = draw!!.minimumWidth
        val minHeight:Int = draw!!.minimumHeight
        draw!!.setBounds(0,0,minWidth,minHeight)

    }
    private fun isShow(isShow:Boolean){
        drawShow = if(isShow){draw}else{null}
        setCompoundDrawables(compoundDrawables[0],compoundDrawables[1],drawShow,compoundDrawables[3])
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun afterTextChanged(s: Editable?) {
        if(TextUtils.isEmpty(text.toString())){
            isShow(false)
        }else{
            isShow(true)
        }
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

}