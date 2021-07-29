/* eslint-disable no-undef */
import React, { useState, useEffect } from "react";

import { FaTimes } from 'react-icons/fa';
import Typography from '@material-ui/core/Typography';
import './App.css'
import Link from '@material-ui/core/Link';
import axios from 'axios';
import SaveCommentComponent from './components/SaveCommentComponent';
import CommentComponent from './components/CommentComponent';
import {data} from './components/Data';

//import APIService from './service/APIService.js';


function Copyright() {


    return (
        <Typography variant="body2" color="textSecondary" align="center">
            {'Copyright © '}
            <Link color="inherit" href="https://material-ui.com/">
                Your Website
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );


}



export const Gallery = () => {

    
    
    

    

    

    const [model, setModel] = useState(false);
    const [tempimgSrc, setTempImgSrc] = useState('');
    const [tempimgAciklama, setImgAciklama] = useState('');
    const [id, setId] = useState(2);


    const getImg = (imgSrc, aciklama,id) => {
        setTempImgSrc(imgSrc)
        setModel(true)
        console.warn(imgSrc)
        setImgAciklama(aciklama)
        setModel(true)
        console.warn(aciklama)
        setId(id)
        setModel(true)
        console.warn(id)
    }

    

    return (
        <>
            <div className={model ? "model open" : "model"}>


                <img src={tempimgSrc} />
                <div className="aciklama">{tempimgAciklama}
                
                </div>
                <CommentComponent pictureId={id} />
                <FaTimes onClick={() => setModel(false)} />
                <div class="comment">
                    <SaveCommentComponent pictureId={id}  />
                </div>

            </div>
            <div className="gallery">
                {
                    data.map((item, index) => {
                        return (
                            <div className="pics" key={index} onClick={() => getImg(item.imgSrc, item.aciklama,item.id)}>
                                <img src={item.imgSrc} />
                                
                            </div>
                        )
                    })
                }

            </div>
            <footer>
                <Typography variant="h6" align="center" gutterBottom>
                    ETERATION
                </Typography>
                <Typography variant="subtitle1" align="center" color="textSecondary" component="p">
                    Something here to give the footer a purpose!
                </Typography>
                <Copyright />
            </footer>
            {/* End footer */}
        </>
    )



}
export default Gallery;