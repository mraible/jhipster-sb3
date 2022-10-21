import { IProject, NewProject } from './project.model';

export const sampleWithRequiredData: IProject = {
  id: 55962,
};

export const sampleWithPartialData: IProject = {
  id: 86564,
  name: 'hertz Plastic',
};

export const sampleWithFullData: IProject = {
  id: 96813,
  name: 'Omnigender Northeast Electric',
};

export const sampleWithNewData: NewProject = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
