import React from 'react';
import logo from '../images/LegalLogo.svg';

const NavBar = () => {

    return (
        <nav>
            <ul>
                <li>
                    <a href="#Home">Home</a>
                </li>
                <li>
                    <a href="#Search">Search</a>
                </li>
                <li>
                    <a href="#About">About</a>
                </li>
            </ul>
            <div className="nav-right">

                <img src={logo} className='nav-icon mr-1' alt='Legal Questioner' />
                Legal Questioner
            </div>
        </nav>
    );
}

export default NavBar;