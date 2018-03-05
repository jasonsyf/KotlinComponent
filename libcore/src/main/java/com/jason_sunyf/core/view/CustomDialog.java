package com.jason_sunyf.core.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jason_sunyf.core.R;

/**
 * 自定义警告dialog,调用方式与AlertDialog一样
 * Created by LWH on 2016/6/16.
 */
public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context context;
        private String title;
        private String message;
        private String positiveBtnText;
        private String negativeBtnText;
        private View contentView;
        private OnClickListener positiveButtonOnClickListener;
        private OnClickListener negativeButtonOnClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setView(View view) {
            this.contentView = view;
            return this;
        }

        public Builder setPositiveButton(String positiveBtnText, OnClickListener listener) {
            this.positiveBtnText = positiveBtnText;
            this.positiveButtonOnClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(int positiveBtnText, OnClickListener listener) {
            this.positiveBtnText = (String) context.getText(positiveBtnText);
            this.positiveButtonOnClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeBtnText, OnClickListener listener) {
            this.negativeBtnText = negativeBtnText;
            this.negativeButtonOnClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButton, OnClickListener listener) {
            this.negativeBtnText = (String) context.getText(negativeButton);
            this.negativeButtonOnClickListener = listener;
            return this;
        }

        public CustomDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CustomDialog dialog = new CustomDialog(context, R.style.CustAlertDialog);
            View view = inflater.inflate(R.layout.dialog_custom, null);
            dialog.addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            TextView titleText = (TextView) view.findViewById(R.id.dialog_custom_title);
            final Button positiveBtn = (Button) view.findViewById(R.id.dialog_custom_positiveBnt);
            titleText.setText(title);
            if (positiveBtnText != null) {
                positiveBtn.setText(positiveBtnText);
                if (positiveButtonOnClickListener != null) {
                    positiveBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            positiveButtonOnClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        }
                    });
                }
            } else {
                positiveBtn.setVisibility(View.GONE);
            }
            Button negativeBtn = (Button) view.findViewById(R.id.dialog_custom_negativeBtn);
            if (negativeBtnText != null) {
                negativeBtn.setText(negativeBtnText);
                if (negativeButtonOnClickListener != null) {
                    negativeBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            negativeButtonOnClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }
            } else {
                negativeBtn.setVisibility(View.GONE);
            }
            TextView messageText = (TextView) view.findViewById(R.id.dialog_custom_message);
            if (message != null) {
                messageText.setText(message);
            } else if (view != null) {
                LinearLayout contentLayout = (LinearLayout) view.findViewById(R.id.dialog_custom_contentLayout);
                contentLayout.removeAllViews();
                contentLayout.addView(contentView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
            }
            dialog.setContentView(view);
            return dialog;
        }
    }
}
