package phil.fsst;

public class CInventar {
    public int place;        // Anzahl der Plätze im Inventar
    public int gew = 0;         // Maximales Gewicht
    public int naechsterFreierInventarplatz;

    public CGegenstand[] bp;




    public void PrintInv(){

        for(int i = 0; i < bp.length; i++){

            if(bp[i] != null) System.out.println(bp[i].getBZ());
        }

    }

    public CInventar() {
        place = 20;
        gew = 50;

        bp = new CGegenstand[place];
    }

    public CInventar(int platz, int gewicht) {
        place = platz;
        gew = gewicht;
    }

  /*  public void creatInv(){
        CGegenstand[] bp = new CGegenstand[place];
    } */

     public void ItemIntoInv(CGegenstand item) {

        if ((checkSpaceAvalible(item)) && (checkWeightAvalible(item))) {
            bp[naechsterFreierInventarplatz] = item;
        }

    }

    public boolean checkSpaceAvalible(CGegenstand item) {
        boolean spaceAvalible = false;

        for (int i = 0; i < bp.length; i++) {
            if (bp[i] == null) {
                naechsterFreierInventarplatz = i;
                spaceAvalible = true;
                break;
            }
        }

        return spaceAvalible;
    }


    public boolean checkWeightAvalible(CGegenstand item) {
        boolean notOverweight = false;
        int gesamtGewicht = 0;

        for (int i = 0; i < place; i++) {
            if (bp[i] != null) {
                gesamtGewicht = gesamtGewicht + bp[i].getGW();
            }

            gesamtGewicht += item.getGW();

            if (gesamtGewicht <= gew) {
                notOverweight = true;
            }

            try {
            }
            catch (IllegalArgumentException k){

            }


        }

        return notOverweight;
    }

}