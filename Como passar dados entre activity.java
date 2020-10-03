
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

<<=========================================================================================================================>>>

/*
*Como retornar dados da Activity chamada para aquela que a chamou?
* Utilizar startActivityForResult() em vez de startActivity().
*/

//Na primeira Activity:
static final int ACTIVITY_2_REQUEST = 1;

Intent i = new Intent(this, SegundaActivity.class);
startActivityForResult(i, ACTIVITY_2_REQUEST);


//Na segunda Activity:
//Quando tiver o resultado pronto para ser devolvido à primeira activity

String resultado = seuTextView.getText().toString();
Intent returnIntent = new Intent();
returnIntent.putExtra("resultado",resultado);
setResult(RESULT_OK,returnIntent);


//Para receber o valor faça o override do método onActivityResult() na primeira Activity

@override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == ACTIVITY_2_REQUEST) {
        if(resultCode == RESULT_OK){
            String resultado = data.getStringExtra("resultado");
            //Coloque no EditText
            seuEditText.setText(resultado);
        }
    }
}









