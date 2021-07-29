import React from 'react'
import APIService from '../service/APIService'
import axios from 'axios';

export default class SaveCommentComponent extends React.Component {

    state = {
        username: '',
        id: '',
        comment: '',
        pictureId: '',

    }

    handleChange = event => {

        this.setState({ comment: event.target.value });

    }
    handleSubmit = event => {
        event.preventDefault();

        
        const comment = {
            username: "emrecanyalcin",
            comment: this.state.comment,
            pictureId: "1",
            id: 1891,


        };

        axios.post(`http://localhost:8080/api/v1/comments/save`, comment)
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        

                        <input type="text" name="comment" onChange={this.handleChange}  placeholder="Yorumunuz"/>

                    </label>
                    <button type="submit">Gönder</button>
                </form>
            </div>
        )
    }

}
