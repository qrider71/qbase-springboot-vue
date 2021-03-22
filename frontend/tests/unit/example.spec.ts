import { expect } from 'chai';
import { shallowMount } from '@vue/test-utils';
import PingView from '@/components/PingView.vue';

describe('PingView.vue', () => {
  it('displays ping view', () => {
    const wrapper = shallowMount(PingView, {});
    expect(wrapper.text()).to.include('Ping');
  });
});
