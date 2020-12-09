package com.example.sip_application;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyPagerAdapter extends CursorRecyclerAdapter<PagerVH> {
    MyDBHelper4 dbHelper5;
    int p;

    int d;
    float h;

    public MyPagerAdapter(Cursor c, MyDBHelper4 dbHelper5) {
        super(c);
        this.dbHelper5 = dbHelper5;
        //this.d = d;
        //this.h = h;
    }

    public PagerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pager2, parent, false);
        return new PagerVH(itemView);
    }

    public void onBindViewHolder(PagerVH holder, Cursor c) {

        final int qIndex = c.getColumnIndex(MyDBHelper4.KEY_PRICE);
        final int qIndex2 = c.getColumnIndex(MyDBHelper4.KEY_QUAN);
        //final int qIndex3 = c.getColumnIndex(MyDBHelper4.KEY_YQUAN);
        //final int qIndex4 = c.getColumnIndex(MyDBHelper4.KEY_YPR);
        holder.textView.setText("            НАИМЕНОВАНИЕ: " + c.getString(1));
        holder.textView2.setText("           СТОИМОСТЬ: " + c.getFloat(qIndex));
        holder.textView2a.setText("          СРОК АРЕНДЫ: " + c.getString(3));
        holder.textView3.setText("           КОЛИЧЕСТВО: " + c.getInt(qIndex2));
        /*holder.textView4.setText("           ВАШЕ КОЛИЧЕСТВО ИНСТРУМЕНТОВ: " + c.getInt(qIndex3));
        holder.textView5.setText("           ВАШЕ ИТОГОВАЯ СТОИМОСТЬ: " + c.getFloat(qIndex4));*/
        final int k = c.getInt(qIndex2);
        final long id = c.getLong(0);
        p = k - 1;

        //holder.button.setTag(new Data(d,h));
        holder.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SQLiteDatabase db = dbHelper5.getWritableDatabase();
                //ContentValues contentValues = new ContentValues();

                db.execSQL("UPDATE INSTR SET QUAN = ? WHERE id = ?", new String[]{ String.valueOf(p), String.valueOf(id) });
                //db.execSQL("UPDATE INSTR SET YQUAN = ? WHERE id = ?", new String[]{ String.valueOf(d), String.valueOf(id) });
                //contentValues.put(MyDBHelper.KEY_QUANTITY, qIndex - 1);
                //db.update(MyDBHelper.TABLE_GOODS, contentValues, MyDBHelper.KEY_ID + "=" + idIndex, null);
                Cursor c = db.query("INSTR", null, null, null, null, null, null);
                swapCursor(c);
                p = p - 1;
                d = d + 1;

            }
        });


    }


}

class PagerVH extends RecyclerView.ViewHolder {
    TextView textView;
    TextView textView2;
    TextView textView2a;
    TextView textView3;
    Button button;


    public PagerVH(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        textView2 = itemView.findViewById(R.id.textView2);
        textView2a = itemView.findViewById(R.id.textView2a);
        textView3 = itemView.findViewById(R.id.textView3);
        button = itemView.findViewById(R.id.buttona);
    }
}
