package com.ltm.ltmlistview3;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fixe l'adaptateur
		setListAdapter(new MonAdaptateur(this));

	}

	class MonAdaptateur extends BaseAdapter {
		
		public MonAdaptateur(Context context, int resource) {
			super();//, resource);
			// TODO Auto-generated constructor stub
		}

		private Integer [] _tab_images = {
				R.drawable.device,
				R.drawable.geolocation,
				R.drawable.accelerometer,
				R.drawable.navigateur_internet,
				R.drawable.notifications,
				R.drawable.album_photo,
				R.drawable.connection_network,
				R.drawable.files,
				R.drawable.carnet_contact};

		String [] values = new String[] { "Device", "Géo localisation",
				"Accéléromètre", "Internet",  "Dialogues", "Album photos",
				"Connexion réseau", "Gestion des fichiers", "Carnet de contacts"
		};

		@Override
		public int getCount() {
			Log.v("ltm", "getCount = " + _tab_images.length);
			return _tab_images.length;
		}

		@Override
		public Object getItem(int position) {
			Log.v("ltm", "getItem("+position+")= "+_tab_images[position]);
			return _tab_images[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			Log.v("ltm", "position = " + position + ", convertView = " + convertView);
			
			// 1. Déplie mon Layout qui réprésente une ligne
			View rowView;
			
			//if(convertView==null){
				LayoutInflater inflater = (LayoutInflater)_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				rowView = inflater.inflate(R.layout.row_layout, parent, false);
				// 2. Editer les widgets
				TextView textView = (TextView)rowView.findViewById( R.id.textView1);
				ImageView imageView = (ImageView)rowView.findViewById(R.id.imageView1);
				imageView.setImageResource(_tab_images[position]);
				textView.setText(values[position]);

			Log.v("ltm", "position = " + position);
			//}else
				//rowView = (View)convertView;
			
			return rowView;
		}

		public MonAdaptateur(Context context) {//, String [] v) {
			_context = context;
		}
		
		private Context _context;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
