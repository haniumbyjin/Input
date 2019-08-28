import React, {Component} from 'react';
import axios from 'axios';

class Fileupload extends Component{

constructor(){
    super();
    this.state={
        currentImage : "",
        fileName :"",
        status: false,
        encodeImg: ""
    }
}

fileHandler = (e) => {
    console.log(e.target.files[0]);
    if(e.target.files !=null || e.target.files[0]!=null){
        this.setState({currentImage : e.target.files[0]});
        this.setState({status:true});
        this.setState({fileName: e.target.files[0].name})

        console.log(this.state);

    if(e.target.files && e.target.files[0]){
        var reader = new FileReader();
        var en = new FileReader();
        var file = e.target.files[0]
        

        var tmp = reader.readAsDataURL(e.target.files[0]);
       // en.readAsDataURL(file);
        this.setState({encodeImg: en.readAsDataURL(file)})

        reader.onload=(e) =>{
            document.getElementById("cover").setAttribute('src',e.target.result);
     //       document.getElementById("source").innerHTML = tmp;
            console.log(e.target.result);
        }
  
      }    
    }else{
        console.log("파일 없음");
    }
}

fileUploadHandler = () => {
    if(this.state.currentImage ==null){

    }else{
    // const fd = new FormData();
    //          fd.append('upload',this.state.currentImage);

          axios({
            params: {
                upload: this.state.encodeImg
            },
            url : 'http://localhost:8082/upload',
            method:'GET',
        //    data: fd,
            headers: 
                {Accept: 'application/json'}
                // 'Content-Type': `multipart/form-data; boundary=${fd._boundary}`}
          })
           .then(function(response){
                console.log(response.data.message);
            }).catch(function(response){
                console.log(response);            
            })
        }
}
removeImage = () => {
    this.setState({
        currentImage:"",
        fileName: "",
        status :false,
        encodeImg: ""
    })
}

render(){
    return(
        <div className="App">
            <input type="file" name="file" id="file" onChange={this.fileHandler}/>
        
        <button onClick={this.fileUploadHandler} >파일 업로드</button>
        <div>
        {
            this.state.status ?(
                <div className="image-container">
                <p className="msg">{this.state.fileName}</p>
                <button onClick={this.removeImage}>X</button>
                <img id = "cover" src = ""/>
                </div>
            ):(
                <p>선택한 이미지 없음</p>
            )
        }
        </div>
        </div>
)};
}
export default Fileupload;