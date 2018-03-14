package com.jason_sunyf.core.adapter.listview

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.SparseArray
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView


/**
 *
 * @author Jason_Sunyf
 * @date 2017/12/16 0016
 * Email： jason_sunyf@163.com
 */
class BaseViewHolder(private val mConvertView: View?, private val mOnClickBack: OnClickBack?
) : View.OnClickListener {
    private val mSparseArray = SparseArray<View>()

    var position: Int = 0

    init {
        if (mConvertView != null) {
            mConvertView.tag = this
        }
    }

    private fun <T : View> findView(viewId: Int): T? {
        var view: View? = null
        if (mConvertView != null) {
            view = mConvertView.findViewById(viewId)
        }
        if (view != null) {
            mSparseArray.put(viewId, view)
        }
        return view as T?
    }

    fun <T : View> getView(viewId: Int): T? {
        var view: View? = mSparseArray.get(viewId)
        if (view != null) {
            return view as T?
        }
        view = findView(viewId)
        return view as T?
    }

    fun setText(viewId: Int, sequence: CharSequence): BaseViewHolder {
        val view = getView<TextView>(viewId)
        if (view != null) {
            view.text = sequence
        }

        return this
    }

    fun setImageRes(viewId: Int, imgResId: Int): BaseViewHolder {
        val view = getView<ImageView>(viewId)
        view?.setImageResource(imgResId)
        return this
    }

    fun setSwitchState(viewId: Int, isChecked: Boolean): BaseViewHolder {
        val sw = getView<Switch>(viewId)
        if (sw != null) {
            sw.isChecked = !isChecked
        }
        return this
    }


    fun setOnClickListener(viewId: Int): BaseViewHolder {
        val view = getView<View>(viewId)
        view?.setOnClickListener(this)
        return this
    }

    fun setLineLayoutListener(viewId: Int): BaseViewHolder {
        val layout = getView<LinearLayout>(viewId)
        layout?.setOnClickListener(this)
        return this
    }


    //给一个imageView设置bitMap
    fun setImageBipmap(bitmap: Bitmap?, viewId: Int): BaseViewHolder {
        if (bitmap == null) {
            return this
        }
        val view = getView<View>(viewId)
        if (view != null && view is ImageView) {
            view.setImageBitmap(bitmap)
        }
        return this
    }

    fun setHint(viewId: Int, `var`: String): BaseViewHolder {
        val editText = getView<EditText>(viewId)
        if (editText != null) {
            editText.hint = `var`
        }
        return this
    }

    //给一个imageView设置显示隐藏
    fun setVisible(viewId: Int, bool: Boolean): BaseViewHolder {
        val view = getView<ImageView>(viewId)
        if (bool) {
            view!!.visibility = View.VISIBLE
        } else {
            view!!.visibility = View.GONE
        }
        return this
    }


    fun setTvVisible(viewId: Int, bool: Boolean): BaseViewHolder {
        val tv = getView<TextView>(viewId)
        if (bool) {
            tv!!.visibility = View.VISIBLE
        } else {
            tv!!.visibility = View.GONE
        }
        return this
    }


    //给一个textView设置text
    fun setTextViewText(viewId: Int, text: String): BaseViewHolder {
        val view = getView<TextView>(viewId)
        view!!.text = text
        return this
    }

    //给一个textView加drawable
    fun setTvDrawable(textId: Int, d: Drawable, location: Int): BaseViewHolder {
        val tv = getView<TextView>(textId)

        d.setBounds(0, 0, d.minimumWidth, d.minimumHeight)
        //左边 上边 右边 下边
        tv!!.setCompoundDrawables(d, null, null, null)
        return this
    }

    fun setTextViewTextColor(viewId: Int, viewColor: Int): BaseViewHolder {
        val textView = getView<TextView>(viewId)
        textView!!.setTextColor(viewColor)
        return this
    }

    //    public View getView(int viewId) {
    //
    //    }
    fun getEdTextString(viewId: Int): String {
        val editText = getView<EditText>(viewId)
        editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        return editText.text.toString()
    }

    fun setBgColor(LayoutId: Int, LayoutColor: Int): BaseViewHolder {
        val layout = getView<LinearLayout>(LayoutId)
        layout!!.setBackgroundResource(LayoutColor)
        return this
    }

    fun setTextViewBgColor(LayoutId: Int, color: Int): BaseViewHolder {
        val textView = getView<TextView>(LayoutId)
        textView!!.setBackgroundColor(color)
        return this
    }

    fun setChecked(LayoutId: Int, ischecked: Boolean?): BaseViewHolder {
        val checkBox = getView<CheckBox>(LayoutId)
        checkBox!!.isChecked = ischecked!!
        return this
    }

    fun setOnclickListener(viewId: Int): BaseViewHolder {
        val view = getView<View>(viewId)
        view?.setOnClickListener(this)
        return this
    }

    override fun onClick(v: View) {
        mOnClickBack?.onClickBack(position, v, this)
    }

}
