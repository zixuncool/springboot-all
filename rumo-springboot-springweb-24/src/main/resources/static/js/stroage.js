
function setSession(key,url){
    localStorage.setItem("rumo."+key,url);
}

function getSession(key){
    return localStorage.getItem("rumo."+key);
}