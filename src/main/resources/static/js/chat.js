let ws = new WebSocket("ws://localhost:8081/message");
ws.onopen=function (){
    console.log("WebSocket connection opened");
}
ws.onmessage=function (event){
    let data = JSON.parse(event.data);
    console.log(event.data)
    console.log(data)

}
ws.onclose=function (){
    console.log("WebSocket connection closed");
}
