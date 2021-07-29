import react from 'react';

import { FaRegThumbsUp } from "react-icons/fa";
import Gallery from './Gallery'

const Hero = ({ handleLogout }) => {
    return (
     
       <section className="hero">
            <nav class="mb-5">
            <h1 align="center"><span className="font-linkpanorama" align="center">Panorama</span></h1>
                <button onClick={handleLogout}><span className="font-linkk">Çıkış</span></button>
            </nav>
            <Gallery/>
            </section>
    )
}
export default Hero;

