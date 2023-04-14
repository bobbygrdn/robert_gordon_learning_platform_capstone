import React from 'react';
import '../../styles/landingPage/GettingStarted.css'

export default function GettingStarted() {
    return (
        <>
            <p className='steps' data-testid="steps">Here is a step by step guide to get you started!</p>
            <div className='gettingStarted'>
                <img className="step" src='/resources/male_meijin.jpg' data-testid="step" alt="Step 1" />

                <img className="arrow arrow1" src='/resources/arrow_right.png' data-testid="arrow" alt="Arrow" />

                <img className="step" src='/resources/male_meijin.jpg' data-testid="step" alt="Step 2" />

                <img className="arrow arrow2" src='/resources/curved_arrow_right.png' data-testid="arrow" alt="Arrow" />

                <img className="step" src='/resources/male_meijin.jpg' data-testid="step" alt="Step 3" />

                <img className="arrow arrow3" src='/resources/curved_arrow_left.png' data-testid="arrow" alt="Arrow" />

                <img className="step" src='/resources/male_meijin.jpg' data-testid="step" alt="Step 4" />

                <img className="arrow arrow4" src='/resources/arrow_right.png' data-testid="arrow" alt="Arrow" />

                <img className="step" src='/resources/male_meijin.jpg' data-testid="step" alt="Step 5" />
            </div>
        </>
    )
}
