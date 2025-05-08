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
document.getElementById('joinRoomForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const roomId = document.getElementById('roomId').value.trim();

    try {
        const response = await fetch('http://localhost:8081/rooms/join', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' // 必须设置
            },
            body: JSON.stringify({
                roomId: roomId // 键名必须与后端完全一致（区分大小写）
            })
        });
        // ...处理响应...
    } catch (error) {
        console.error('请求错误:', error);
    }
});