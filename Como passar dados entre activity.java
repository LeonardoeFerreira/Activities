
// Passando dados entre activity
/*
* @autho: Leonardo dos Santos Ferreira 
*
*/

1ª Activity:

Intent i = new Intent(Activity.this, NewActivity.class);
i.putExtra("key", value);
startActivity(i);

2ª Activity:

Bundle extras = getIntent().getExtras();
if (extras != null) {
    String value = extras.getString("key");
}
