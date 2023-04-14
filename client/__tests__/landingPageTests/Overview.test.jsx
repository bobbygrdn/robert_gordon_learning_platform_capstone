import React from 'react';
import { configure, shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import Overview from '../../src/components/landingPage/Overview';

configure({ adapter: new Adapter() });

jest.mock('../../src/styles/landingPage/Overview.css', () => ({}));
jest.mock('../../src/styles/App.css', () => ({}));

it('renders without crashing', () => {
    const wrapper = shallow(<Overview />);
    expect(wrapper).toMatchSnapshot();
})

it('should render paragraph element with class of text', () => {
    const wrapper = shallow(<Overview />);
    expect(wrapper.find('p.overviewText')).toHaveLength(1);
})

it('should render paragraph element with class of callStatement', () => {
    const wrapper = shallow(<Overview />);
    expect(wrapper.find('p.callStatement')).toHaveLength(1);
})