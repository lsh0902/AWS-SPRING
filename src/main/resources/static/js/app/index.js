const button = document.querySelector("#btn-save");
const updateButton = document.querySelector("#btn-update");
const title =  document.querySelector("#title");
const author =  document.querySelector("#author");
const content =  document.querySelector("#content");
const postId = document.querySelector("#id");
let main = {
    init : function() {
        let _this = this;
        button.addEventListener('click', ()=>{
            _this.save();
        })
        updateButton.addEventListener("click", ()=>{
            _this.update();
        })
    },
    save : function() {
        let data = {
            title : title.value,
            author: author.value,
            content : content.value
        };
        console.log(data);

        fetch("/api/v1/posts", {
            method:"POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify(data)
        }).then((res)=> {
            console.log(res);
            alert("등록 성공!");
            window.location.href="/";
        }).catch(alert);
    },
    update : function() {
        let data = {
            title: title.value,
            content:content.value
        };
        let id = postId.value;
        fetch("/api/v1/posts", {
            method : 'PUT',
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify(data)
        }).then(res => {
            alert("수정 성공");
            window.location.href = "/";
        }).catch(res => alert(JSON.stringify(res)));

    }
}

main.init();