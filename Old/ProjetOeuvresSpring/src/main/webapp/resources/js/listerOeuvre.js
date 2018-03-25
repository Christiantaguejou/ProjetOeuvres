/* FONCTION DE TRI DU TABLEAU*/
function sortTable(n) {
    var table, ligne, trier, i, x, y, aChanger, dir, cpt = 0;
    table = document.getElementById("tableFilter");
    trier = true;
    dir = "asc";
    while (trier) {
        trier = false;
        ligne = table.getElementsByTagName("tr");
        for (i = 1; i < (ligne.length - 1); i++) {
            aChanger = false;
            x = ligne[i].getElementsByTagName("td")[n];
            y = ligne[i + 1].getElementsByTagName("td")[n];

            if (dir == "asc") {
                if(n == 1){
                    var a = parseInt(x.textContent);
                    var b = parseInt(y.textContent);
                    if(a > b){
                        aChanger = true;
                        break;
                    }
                }
                else if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    aChanger= true;
                    break;
                }
            } else if (dir == "desc") {
                if(n == 1){
                    var a = parseInt(x.textContent);
                    var b = parseInt(y.textContent);
                    if(a < b){
                        aChanger = true;
                        break;
                    }
                }
                else if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    aChanger= true;
                    break;
                }
            }
        }
        if (aChanger) {

            ligne[i].parentNode.insertBefore(ligne[i + 1], ligne[i]);

            trier = true;
            cpt ++;
        } else {
            if (cpt == 0 && dir == "asc") {
                dir = "desc";
                trier = true;
            }
        }
    }
}