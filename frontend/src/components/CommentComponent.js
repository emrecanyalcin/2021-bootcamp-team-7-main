

import React from 'react'
import APIService from '../service/APIService'
import {data} from './Data';

export default class CommentComponent extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            comments: []
        }
        
    }


    componentDidUpdate(props) {
        //const pictureId = data.id;
        APIService.getComment(this.props.pictureId)
        .then(data => this.setState({ comments:data.data}))
            .catch(function (ex) {
                console.log('Response parsing failed. Error: ', ex);
            },4000)
            
    }
    
    

    render() {
        return (
            <table>
                <td>
                    
                    {this.state.comments.map(comment => <td>{comment.username}</td>)}
                    
                </td>
                <tr>
                {this.state.comments.map(comment => <td>{comment.comment}</td>)}
                </tr>
            </table>
           /* <ul>
                {this.state.comments.map(comment => <li>{comment.username}</li>)}
                {this.state.comments.map(comment => <li>{comment.comment}</li>)}
            </ul> */
            
        )
    }

    
}


