const button = document.querySelector("#btn-save");

let main = {
    init : function() {
        let _this = this;
        button.addEventListener('click', ()=>{
            _this.save();
        })
    },
    save : function() {
        const title =  document.querySelector("#title");
        const author =  document.querySelector("#author");
        const content =  document.querySelector("#content");
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
    }
}

main.init();