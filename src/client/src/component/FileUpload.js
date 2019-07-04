import React, {Component} from 'react';

class Fileupload extends Component{

    fileSelectedHandler = event =>{
        // 파일선택
    }

    fileUploadHandler = () =>{
        // 파일 업로드
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