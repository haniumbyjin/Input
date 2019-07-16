import React, {Component} from 'react';
import axios from 'axios';

class Fileupload extends Component{
    state = {
        selectedFile : null
    }

    fileSelectedHandler = event =>{
        // 파일선택
        this.setState =({
            selectedFile: event.target.files[0]
        })
    } 

    fileUploadHandler = () =>{
        // 파일 업로드
        const fd = new FormData();
        fd.append(this.state.selectedFile, this.state.selectedFile);
        axios.post('http://localhost:8080/upload', fd)
        .then(res =>{
            console.log(res);
        });
    }

 
    render(){
        return(
            <div>
                <input type="file" onChange={this.fileSelectedHandler}/>
                <button onClick={this.fileUploadHandler}>파일 업로드</button>
            </div>
        );
    }
}

export default Fileupload;