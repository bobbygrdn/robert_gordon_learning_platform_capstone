import React, { useEffect } from 'react';
import { Form, useNavigate } from 'react-router-dom';
import Button from '../landingPage/Button';
import '../../styles/authentication/Login.css';
import Header from '../landingPage/Header';
import { useStore } from 'zustand';
import useCredentialStore from '../../store/useCredentialsStore';
import { toast } from 'react-toastify';

export default function Login({ token }) {
    const { userName, setUserName, password, setPassword, setUserId, keepLoggedIn, setKeepLoggedIn, disabled, setDisabled } = useStore(useCredentialStore);

    const navigate = useNavigate();

    useEffect(() => {
        if (userName && password) {
            setDisabled(false);
        } else {
            setDisabled(true);
        }
    }, [userName, password, setDisabled])

    function isMobileDevice() {
        return (typeof window.orientation !== "undefined") || (navigator.userAgent.indexOf('IEMobile') !== -1);
    }

    const loginUser = async (e) => {
        e.preventDefault();
        await fetch('/api/v1/users')
            .then(response => response.json())
            .then(data => {

                const users = data;

                const user = users.find(user => user.username === userName && user.password === password);

                if (user) {
                    if (keepLoggedIn === false) {
                        sessionStorage.setItem('token', user.token);
                        setUserId(user.id);
                    }
                    if (keepLoggedIn === true) {
                        localStorage.setItem('token', user.token);
                        setUserId(user.id);
                    }

                    toast.success("Successfully logged in!");
                    if (user.role === "Admin") {
                        if (isMobileDevice()) {
                            // User is on a mobile device
                            navigate('/deviceIssue');
                        } else {
                            // User is on a desktop device
                            navigate('/admin/content');
                        }
                    } else {
                        navigate('/dashboard/profile');
                    }
                } else {
                    toast.error("User not found!");
                }
            })
    }

    if (token != null) {
        navigate('/dashboard')
    }

    return (
        <div className='login-wrapper'>
            <Header />
            <Form className='login-form'>
                <h1 className='loginTitle'>Login</h1>
                <label className='username'>
                    <p className='userTitle'>Username</p>
                    <input className='userInput' type="text" placeholder="Username" onChange={e => setUserName(e.target.value)} />
                </label>
                <label className='password'>
                    <p className='passwordTitle'>Password</p>
                    <input className='passwordInput' type="password" placeholder="Password" onChange={e => setPassword(e.target.value)} required />
                </label>
                <label className='keepLoggedIn'>
                    <p className='subheading'>Keep me logged in</p>
                    <input className='checkbox' type="checkbox" onChange={e => setKeepLoggedIn(e.target.checked)} required />
                </label>
                <div disabled={disabled}>
                    <Button purpose='login' text='Login' onClick={loginUser} />
                </div>
                <p className='signupAccount'>If you do not have an account, please <a href="/signup">signup</a> here.</p>
            </Form>
        </div>
    )
}
