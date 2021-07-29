import axios from 'axios';
import Gallery from '../Gallery';

const COMMENT_API_REST_URL = "http://localhost:8080/api/v1/comments";


class APIService {
    
    getComment(pictureId){
        return axios.get(COMMENT_API_REST_URL + '/' + pictureId);
    }


    

}



export default new APIService();