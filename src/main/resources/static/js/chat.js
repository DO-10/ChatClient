let ws = new WebSocket("ws://localhost:8081/message");
ws.onopen=function (){
    console.log("WebSocket connection opened");
}
ws.onmessage=function (event){
    let data = JSON.parse(event.data);
    console.log(event.data)
    console.log(data)
    var messageElement = document.createElement('div');
    messageElement.classList.add('message-item');  // 你可以给它添加样式
    messageElement.textContent = data.message+data.warning;// 显示消息的内容

    var messageContainer = document.querySelector('.messages');
    messageContainer.appendChild(messageElement);  // 添加到页面中
}
ws.onclose=function (){
    console.log("WebSocket connection closed");
}

document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("messageForm");
    const textarea = document.getElementById("messageContent");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // 阻止表单默认提交行为

        const message = textarea.value.trim();
        if (!message) return;

        fetch("/chat", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: new URLSearchParams({ message })
        })
            .then(response => {
                if (!response.ok) throw new Error("Failed to send message.");
                textarea.value = ""; // 清空输入框
            })
            .catch(err => {
                console.error("Error sending message:", err);
                alert("发送失败！");
            });
    });
});
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